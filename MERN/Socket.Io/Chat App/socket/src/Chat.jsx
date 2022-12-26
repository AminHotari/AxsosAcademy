import React, { useState, useEffect }  from 'react'
import io from 'socket.io-client';

const Chat = (props) => {
  
    const [socket] = useState(() => io(':8000')); // connecting to backend

    const [text, setText] = useState("");
    const [message,setMessage] = useState([]);
  
    useEffect(() =>{

      socket.on("amin", data=> console.log(data));
      socket.on("chat", data=> setMessage([data,...message]));
      socket.on("joinName", data=>setMessage(data));
  
      // return () => socket.disconnect(true);
  
    },[message]);

    const onSubmit =(e)=>{
      e.preventDefault();
      socket.emit("chat", props.myname + " said "+ text);
      setText("");
    }

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
        // height:"10rem",
        border:"0.1rem solid black",
        overflowY:"scroll",
    }

  return (
    <div>
      <h2 style={head}>MERN Chat</h2>
      <br></br>
      <main style={forMain}>
      <p style={{backgroundColor:"#9fc5f8",width:"30%",overflowY:"auto",border:"0.1rem solid black",borderRadius:"1rem",}}>{message.map((msg,index)=>
        <p key={index}>{msg}</p>
      )}</p>
      <form onSubmit={onSubmit}>
        <input style={{width:"85%",height:"2rem",margin:"0.5rem 1rem 0.5rem 0"}} type="text" onChange={(e)=>setText(e.target.value)} value={text}/>
        <button style={{color:"white",backgroundColor:"#2b78e4"}}>Send</button>
      </form>
      </main>
    </div>
  )
}

export default Chat
