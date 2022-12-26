import React from 'react'
import { useState } from 'react'
import io from 'socket.io-client';

const Form = (props) => {
    const [socket] = useState(() => io(':8000'));
    const [nickname,setNickname] = useState("")

    const head={
        margin: "0 auto",
        width:"50%",
        backgroundColor:"#dddddd",
        color:"black",
        marginTop: "2rem",
        height:"4rem",
        border:"0.1rem solid black",
        fontWeight:"500",
    }

    const forMain={
        margin: "0 auto",
        width:"50%",
        height:"10rem",
        border:"0.1rem solid black",
    }

    const onSubmit =(e)=>{
        e.preventDefault();
        props.user(nickname);
      }

  return (
    <div>
      <h2 style={head}>MERN Chat</h2>
      <br></br>
      <form style={forMain} onSubmit={onSubmit}>
        <h3 style={{fontWeight:"500"}}>Get started right now!</h3>
        <p>I want to start chating with the name...</p>
        <input type="text" placeholder='My name...' onChange={(e)=>setNickname(e.target.value)}/>
        <button>Start Chating</button>
      </form>
    </div>
  )
}

export default Form
