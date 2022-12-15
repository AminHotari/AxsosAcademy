import React, {useState} from 'react'

const DisplayTodo = (props) => {
  return (
    <div>
      {props.showTodo.map((item,index) =>{
        if(item.completed){
          return(
            <del>
              <p key={index}>{item.text} 
              <input type="checkbox" checked={item.completed} onChange={(e)=>{props.updateTodo(index)}} />
              <button onClick={(e)=>props.delete(index)}>Delete</button></p>
            </del>
          )         
        }
        else{
          return(
            <p key={index}>{item.text} 
            <input type="checkbox" checked={item.completed} onChange={(e)=>{props.updateTodo(index)}} />
            <button onClick={(e)=>props.delete(index)}>Delete</button></p>
          )          
        }
      })}
    </div>
  )
}
export default DisplayTodo
