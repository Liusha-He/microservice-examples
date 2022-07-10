import './App.css';
import React, {useState, useEffect} from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css"
import TodoView from "./components/todoListView";

function App() {

  const [todoList, setTodoList] = useState([{}]);
  const [title, setTitle] = useState("");
  const [desc, setDesc] = useState("");

  useEffect(() => {
    axios.get("http://localhost:8080/v1/api/todo")
    .then(res => {
      setTodoList(res.data)
    })
  });

  const addTodoHandler = () => {
    axios.post("http://localhost:8080/v1/api/todo",
    {
      "title": title, "description": desc
    }).then(res => console.log(res))
  }

  return (
    <div className="App">
      <div className='App list-group-item 
      justify-content-center
      align-items-center mx-auto'
      style={{"width": "400px", 
              "backgroundColor": "white",
              "marginTop": "15px"}}>
            <h1 className="card text-white bg-primary mb-1"
             styleName="max-width: 20rem;">Task Manager</h1>
             
             <h3 className="card text-white bg-primary mb-3">FARM</h3>
             <div className="card-body">

              <h5 className="card text-white bg-primary mb-3">Add Your Task</h5>
              <spam className="card-text">
                <input className="mb-2 from-control titleIn" 
                onChange={event => setTitle(event.target.value)}
                placeholder="title"/>
                <input className="mb-2 from-control desIn" 
                onChange={event => setDesc(event.target.value)}
                placeholder="description"/>

                <button className="btn btn-outline-primary mx-2 mb-3" 
                onClick={addTodoHandler}
                style={{"borderRadius": "50px", "font-weight":"bold"}}>Add Task</button>
              </spam>

              <h5 className="card text-white bg-primary mb-3">Your Tasks</h5>
              <div>
                <TodoView todoList={todoList} />
              </div>

              <h6 className="card text-dark bg-warning py-1 mb-0">Copyright 2021, All rights reserved &copy;</h6>
             </div>
      </div>
    </div>
  );
}

export default App;
