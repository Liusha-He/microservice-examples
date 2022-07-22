import axios from "axios";
import React from "react";

function TodoItem(props) {
    const deleteTodoHandler = (title) => {
        axios.delete("http://localhost:8000/api/todo/${title}")
        .then(res => console.log(res))
    }

    return (
        <div>
            <p>
                <spam style={{fontWeight: "bold, underline"}}>
                    {props.todo.title} : </spam> {props.todo.description}
                <button 
                className="btn btn-online-danger my-2 mx-2"
                onClick={
                    () => {
                        deleteTodoHandler(props.todo.title)
                    }
                }
                style={{"borderRadius": "50px"}}
                >X</button>
                <hr></hr>
            </p>
        </div>
    )
}

export default TodoItem;
