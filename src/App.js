import './App.css';
import React from 'react';
import Todo from './Todo';
import {Paper, List, Container} from '@material-ui/core';
import AddTodo from './AddTodo.js';
import { call } from './ApiService';


class App extends React.Component {

  constructor(props){
    super(props);
    //1. item -> items 배열로
    this.state = {
      items:[  ]
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
      this.setState({items:response.data})
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

   return (
    <div className="App">
      <Container maxWidth="md">
        <AddTodo add={this.add}/>
        <div className="TodoList">{todoItems}</div>
      </Container>
    </div>
   )
 }

}


export default App;
