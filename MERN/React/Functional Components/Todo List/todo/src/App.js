import logo from './logo.svg';
import './App.css';
import React,{useState} from 'react';
import Todo from './components/Todo';
import DisplayTodo from './components/DisplayTodo';


function App() {
  const [todos, setTodos] = useState([]);

  const addMyTodo =(todo) =>{
    setTodos([...todos,todo]);
  }

  const deleteTodo=(index)=>{
    setTodos(todos.filter((item,index1)=>index!=index1))
  }

  const update=(index2)=>{
    const theTodo = todos.filter((todo,i)=>i==index2);
    theTodo[0].completed =! theTodo[0].completed;
    setTodos([...todos]);
  }
  
  return (
    <div className="App">
      <Todo myTodo={addMyTodo}/>
      <DisplayTodo showTodo={todos} delete={deleteTodo} updateTodo={update} />
    </div>
  );
};

export default App;
