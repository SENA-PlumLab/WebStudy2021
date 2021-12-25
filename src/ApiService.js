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
    
    console.log(request);
    return fetch(options.url, options)
            .then((response) => {
                //console.log('request: ', request);
                //console.log('response: ', response);
                if(response.status === 403){
                    console.log('403!');
                    window.location.href = "/login"; //redirect
                }
            })
            .then( (response) => 
                response.json().then((json) => {

                    if(!response.ok){
                        return Promise.reject(json);
                    }
                    return json;
                })
           .catch((error) => {
                console.log('error: ', error);

                /*
                if(error.status === 403){
                    window.location.href = "/login"; //redirect
                }
                 // 403 에러가 뜨는데 response가 적절하지 않음.. 404 403은 네트워크 문제가 아니어서 fetch가 안잡는다는 얘기도 있고..ㄱ-
                // 아무튼 error.status가 텅 비어있는 경우가 있어서 그냥 위에서 response.status로 쓰기로 함.
                */
                return Promise.reject(error);
            })
        );
            
}

export function signin(userDTO) {
    return call("/auth/signin", "POST", userDTO)
            .then( (response) => {
                
                console.log('signin call response: ', response);
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

export function signout(){
    localStorage.setItem(ACCESS_TOKEN, null);
    window.location.href = "/login";
}