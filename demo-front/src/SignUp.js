import { Button, Container, Grid, Link, TextField, Typography } from "@material-ui/core";
import { signup } from "./ApiService";

import React from "react";

class SignUp extends React.Component {
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
    
        // 오브젝트에서 form에 저장된 데이터를 맵의 형태로 바꿔줌
        const data = new FormData(event.target);
    
        const username = data.get("username");
        const email = data.get("email");
        const password = data.get("password");
    
        signup( {email: email, username: username, password: password}).then(
            (response) => {
                //계정 생성 성공 시 login 페이지로 redirect
                window.location.href="/login";
            }
        )
    };

    render(){
        return (
            <Container component="main" maxWidth="xs" style={{margintTop:"8%"}}>
                <form noValidate onSubmit={this.handleSubmit}>
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <Typography component="h1" varient="h5">
                                계정 생성
                            </Typography>
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                autoComplete="fname"
                                name="username"
                                variant="outlined"
                                required
                                fullWidth
                                id="username"
                                label="사용자 이름"
                                autoFocus
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                autoComplete="email"
                                name="email"
                                variant="outlined"
                                required
                                fullWidth
                                id="email"
                                label="이메일"
                                autoFocus
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                autoComplete="current-password"
                                name="password"
                                variant="outlined"
                                required
                                fullWidth
                                id="password"
                                type="password"
                                label="패스워드"
                                autoFocus
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <Button 
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary">
                                계정 생성
                            </Button>
                        </Grid> 
                    </Grid>
                    <Grid container justifyContent="flex-end">
                        <Grid item>
                            <Link href="/login" variant="body2">
                                이미 계정이 있습니까? 로그인 하세요.
                            </Link>
                        </Grid>
                    </Grid>
                </form>
            </Container>
        );
    }    
}


export default SignUp;