import { Link } from '@reach/router';
import React, { useState } from 'react'

const AuthorForm = (props) => {
    const [name,setName] = useState(props.initialName);
    const [title,setTitle] = useState(props.title);


    const forTable={
        margin: "0 auto",
        marginTop: "3rem",
        width:"30%",
    }

    const forTr={
        backgroundColor:"#f6f6f6",
        heigth:"5rem",
        textAlign: "initial",
    }

    const forTd={
        backgroundColor:"#f6f6f6",
    }
    const forInput={
        width:"12%",
        marginTop:"1rem"
    }

    const onSubmitHandle = (e)=>{
        e.preventDefault();
        props.created({name});
        setName("");
    }

  return (
    <div>
        <Link to={"/"}>Home</Link>
        <p>{title}:</p> 
        <form onSubmit={onSubmitHandle}>    
            <table style={forTable}>
                {props.error.map((err1,index)=><p key={index}>{err1}</p>)}
                <tr>
                    <td style={forTr}>Name:</td><br></br>
                    <td style={forTd}><input type="text" onChange={(e)=>setName(e.target.value)} value={name} /></td>
                </tr>
            </table>
            <Link to={"/"}><input type="submit" value="Cancel" style={forInput}/></Link>
            <input type="submit" value="Submit" style={forInput}/>
        </form>
    </div>
  )
}

export default AuthorForm
