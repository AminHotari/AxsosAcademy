import React, { useState } from "react";
import axios from "axios";

export default () =>{
    const [title,setTitle] = useState("");
    const [price,setPrice] = useState(0.0);
    const [desc , setDesc] = useState("");

    const created = (e) =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/product',{
            title : title,
            price:price,
            description: desc,
        })
            .then(res=> {console.log(res);setTitle("");setPrice(0.0);setDesc("")})
            .catch(err=> console.log(err))
    }

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

    return (
        <form onSubmit={created}>
            <h2>Product Manager</h2>
            <table style={forTable}>
                <tr>
                    <td style={forTr}>Title</td>
                    <td style={forTd}><input type="text" onChange={(e)=>setTitle(e.target.value)} value={title} /></td>
                </tr><br></br>
                <tr>
                    <td style={forTr}>Price</td>
                    <td style={forTd}><input type="number" step="0.01" min= "0" onChange={(e)=>setPrice(e.target.value)} value={price} /></td>
                </tr><br></br>
                <tr>
                    <td style={forTr}>Descreption</td>
                    <td style={forTd}><input type="text" onChange={(e)=>setDesc(e.target.value)} value={desc} /></td>
                </tr>
            </table>
            <input type="submit" value="Create" style={forInput}/>
        </form>
    )
}