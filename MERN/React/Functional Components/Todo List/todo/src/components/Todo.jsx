import React, { useState } from 'react'

const Todo = (props) => {
    const [newTodo, setNewTodo] = useState({});
    const [text1,setext1] = useState(newTodo.text)

    const addTodo = (e) =>{
        e.preventDefault();     
        props.myTodo(newTodo);
        setext1("");
        console.log(newTodo);
    }

    const typing = (e)=>{
      setNewTodo({
        text: e.target.value,
        completed: false,
      })
      setext1(e.target.value);
    }

    


  return (
    <div>
      <form onSubmit={addTodo}>
        <input type="text" onChange={typing} value={text1} />
        <div>
        <input type="submit" value= "Add" />
        </div>
      </form>
      <hr></hr> 
    </div>
  )
}

export default Todo
