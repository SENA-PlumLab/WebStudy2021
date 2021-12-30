import { Button, Container, Grid, Link, TextField, Typography } from "@material-ui/core";
import React from "react";
import { signin } from "./ApiService";

class Login extends React.Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event){
        event.preventDefault();
        const data = new FormData(event.target);
        const email = data.get("email");
        const password = data.get("password");

        //ApiService의 signin 메서드를 사용해 로그인
        signin( {email:email, password:password});
    }

    render(){
        return (
            <Container component="main" maxWidth="xs" style={{marginTop:"8%"}}>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <Typography component="h1" variant="h5">
                            로그인
                        </Typography>
                    </Grid>
                </Grid>
                <form noValidate onSubmit={this.handleSubmit}>
                    {" "}
                    {/* submit 버튼을 클릭하면 handleSubmit이 실행 됨 */}
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <TextField
                                varient="outlined"
                                required
                                fullWidth={true}
                                id="email"
                                label="이메일 주소"
                                name="email"
                                autoComplete="email"
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                                varient="outlined"
                                required
                                fullWidth={true}
                                type="password"
                                id="password"
                                label="패스워드"
                                name="password"
                                autoComplete="current-password"
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <Button
                                type="submit"
                                fullWidth={true}
                                varient="contained"
                                color="primary"
                            >
                                로그인
                            </Button>
                        </Grid>
                    </Grid>
                    <Grid container justifyContent="flex-end">
                        <Grid item xs={12}>
                            <Link href="/signup" variant="body2">
                                계정이 없습니까? 회원가입 하세요.
                            </Link>
                        </Grid>
                    </Grid>
                </form>
            </Container>
        );
    }
}

export default Login;