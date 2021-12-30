import './App.css';
import React from 'react';
import Todo from './Todo';
import {AppBar, Grid, Toolbar, Typography, Button, Paper, List, Container} from '@material-ui/core';
import AddTodo from './AddTodo.js';
import { signout, call } from './ApiService';


class App extends React.Component {

  constructor(props){
    super(props);
    //1. item -> items 배열로
    this.state = {
      items:[  ],
      loading: true,
    };
  }
  /*
 render(){
   //2. 자바스크립트가 제공하는 map 함수를 이용해 배열을 반복. <Todo ../> 컴포넌트 생성
   var todoItems = this.state.items.map((item, idx) => (
     <Todo item={item} key={item.id} />
   ));
    //3. 생성된 컴포넌트 리턴
   return <div className="App">{todoItems}</div>
 }
 */

 componentDidMount(){
   call("/todo", "GET", null).then((response) => 
      this.setState({items:response.data, loading:false})
    );

 }
 
 add = (item) => {
   call("/todo", "POST", item).then( (response) =>
      this.setState( {items:response.data})
    );
 }

 delete = (item) => {
  call("/todo", "DELETE", item).then( (response) =>
     this.setState( {items:response.data})
   );
  }
  update = (item) => {
    call("/todo", "PUT", item).then( (response) =>
      this.setState( {items:response.data})
    );
  }



 /*

 //react 어플리케이션 단독으로 사용할 때

add = (item) => {
    const thisItems = this.state.items;
    item.id = "ID-"+thisItems.length; //ke를 위한 id 추가
    item.done = false; //done 초기화
    thisItems.push(item); //리스트에 아이템 추가
    this.setState({items:thisItems}); //업데이트는 반드시 setState로 해야 함
    console.log("items: ", this.state.items);
   }

delete = (item) => {
  const thisItems = this.state.items;
  console.log("Before Update Items: ", this.state.items);
  const newItems = thisItems.filter(e => e.id !== item.id);
  this.setState({items:newItems }, ()=>{
    //디버깅 콜백
    console.log("Update Items: ", this.state.items)
  });
}
*/

 render(){
   var todoItems = this.state.items.length > 0 && (
    <Paper style={{margin:16}}>
      <List>
        {this.state.items.map((item, idx) => (
          <Todo 
            item={item} 
            key={item.id} 
            delete={this.delete}
            update={this.update} />
        ))}
      </List>
    </Paper>
   );

 
   // navigationBar 추가
   var navigationBar = (
     <AppBar position="static">
       <Toolbar>
         <Grid jusrifycontent="space-between" container>
           <Grid item style={{marginLeft:'auto'}}>
             <Typography varient="h6">오늘의 할 일</Typography>
           </Grid>
           <Grid item style={{marginLeft:'auto'}}>
             <Button color="inherit" onClick={signout} >
               로그아웃
             </Button>
           </Grid>
         </Grid>
       </Toolbar>
     </AppBar>
   );
   
   // 로딩중이 아닐 때 렌더링할 부분
   var todoListPage = (
     <div>
       {navigationBar} {/* 내비게이션 바 렌더링*/}
    <Container maxWidth="md">
      <AddTodo add={this.add}/>
      <div className="TodoList">{todoItems}</div>
    </Container>
     </div>
   );

   //로딩 중일 때 렌더링 할 부분
   var loadingPage = (
     <h1> 로딩 중...</h1>
   );

   var content = loadingPage;
   if (!this.state.loading){
     content = todoListPage;
   }

    // props로 넘겨주기
   return (
    <div className="App">
      {content}
    </div>
   )
 }

}


export default App;
