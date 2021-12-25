import { API_BASE_URL } from "./app-config";

const ACCESS_TOKEN = "ACCESS_TOKEN";

export function call(api, method, request){

    let headers = new Headers({
        "Content-Type":"application/json",
        'Accept': 'application/json',
    });

    // localStrorage에서 ACCESS_TOKEN 가져오기
    const accessToken = localStorage.getItem(ACCESS_TOKEN);
    if(accessToken && accessToken!==null){
        headers.append("Authorization", "Bearer "+accessToken);
    }

    let options = {
        headers: headers,
        url: API_BASE_URL + api,
        method: method,
    };

    if(request){
        //GET method
        options.body = JSON.stringify(request);
    }

    return fetch(options.url, options)
            .then( (response) => {

                response.json().then((json) => {

                    if(!response.ok){
                        return Promise.reject(json);
                    }
                    return json;
                })
            })
            .catch((error) => {
                console.log('error: ', error);
                if(error.status === 403){
                    window.location.href = "/login"; //redirect
                }
                return Promise.reject(error);
            });
}

export function signin(userDTO) {
    return call("/auth/signin", "POST", userDTO)
            .then( (response) => {
                console.log("response: ", response);

                if(response.token){
                    localStorage.setItem(ACCESS_TOKEN, response.token);
                    window.location.href="/";
                }
            });
}
/*
export function signin(userDTO) {
    return call("/auth/signin", "POST", userDTO)
            .then( (response) => {
                response.json().then(json => {
                    //console.log("json: ", json);
                    //alert("로그인 토큰: "+json.token);

                    if(json.token) {
                        //token이 존재하는 경우!

                        localStorage.setItem("ACCESS_TOKEN", json.token);
                        window.location.href="/";
                    }
                })
            });
}
*/