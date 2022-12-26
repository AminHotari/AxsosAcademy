import React,{useState} from 'react'
import Chat from './Chat'
import Form from './Form'
import io from 'socket.io-client';

const Main = () => {
    const [socket] = useState(() => io(':8000'));
    const [comeName,setComeName] = useState("");

    const join = (e)=>{
        setComeName(e)
        socket.emit("joinName", e + " has joined the chat" )
    }
  return (
    <div>
        {comeName?
        <Chat myname={comeName}/>:
        <Form user={join}/>}
    </div>
  )
}

export default Main
