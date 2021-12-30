import { Checkbox, IconButton, InputBase, ListItem, ListItemSecondaryAction, ListItemText } from '@material-ui/core';
import { DeleteOutlined } from '@material-ui/icons';
import React from 'react';

class Todo extends React.Component {

    constructor(props){
        super(props);
        this.state = {item: props.item, readOnly:true};
        this.delete = props.delete;
        this.update = props.update;
    }    
    
    offReadOnlyMode = () => {
        console.log("Event! ", this.state.readOnly)
        this.setState({readOnly:false}, () => {
            console.log("ReadOnly? ", this.state.readOnly)
        });
    }

    enterKeyEventHandler = (e) => {
        if(e.key === "Enter") {
            this.setState({readOnly: true});
            this.update(this.state.item); //엔터 누르면 저장
        }
    }

    editEventHandler = (e) => {
        const thisItem = this.state.item;
        thisItem.title = e.target.value;
        this.setState({item: thisItem});
    }

    deleteEventHandler = () => {
        this.delete(this.state.item);
    }

    checkboxEventHandler = (e) => {
        const thisItem = this.state.item;
        thisItem.done = !thisItem.done;
        this.setState({item: thisItem});
        this.update(this.state.item); //체크박스 변경 시 저장
    }

    render(){
        const item = this.state.item;
        return(
            <ListItem>
                <Checkbox 
                    checked={item.done}
                    onChange={this.checkboxEventHandler} />
                <ListItemText>
                    <InputBase
                        inputProps = { {
                            "aria-label":"naked",
                            readOnly: this.state.readOnly}}
                        onClick={this.offReadOnlyMode}
                        onKeyPress={this.enterKeyEventHandler}
                        onChange={this.editEventHandler}
                        type="text"
                        id={item.id}
                        name={item.id}
                        value={item.title}
                        multiline={true}
                        fullWidth={true}
                    />
                </ListItemText>
                <ListItemSecondaryAction>
                    <IconButton 
                    aria-label="Delete Todo"
                    onClick={this.deleteEventHandler}>
                        <DeleteOutlined />
                    </IconButton>
                </ListItemSecondaryAction>
            </ListItem>
        );
    }
}

export default Todo;