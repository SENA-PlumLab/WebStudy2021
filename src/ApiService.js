import { API_BASE_URL } from "./app-config";

export function call(api, method, request){
    let options = {
        headers: new Headers({
            "Content-Type":"application/json",
        }),
        url: API_BASE_URL + api,
        method: method,
    };

    if(request){
        //GET method
        options.body = JSON.stringify(request);
    }
    
    return fetch(options.url, options)
            .then( (response) => 
                 {
                     console.log(response);
                     if(response.status === 403) {
                        window.location.href = "/login"; //redirect
                     }
                     else if(!response.ok) {
                        
                        return Promise.reject(response);
                    }
                    return response;
                     /*
                    if(!response.ok) {
                        //response.ok가 true 이면 정상적인 응답을 받은 것이고,...
                        //true가 아니면 에러 응답임
                        return Promise.reject(json);
                    }
                    return json;
                    */
                }
            )
            .catch((error) => {
                //접근 거부 라우팅 추가.. 아니 안먹어서 ㅠㅠㅠ 위 코드를 수정함.
                console.log('error: ', error);
                console.log('status: ', error.status);
                console.log('message: ', error.message)
                if(error.status === 403){
                    window.location.href = "/login"; //redirect
                }
                return Promise.reject(error);
            });
};