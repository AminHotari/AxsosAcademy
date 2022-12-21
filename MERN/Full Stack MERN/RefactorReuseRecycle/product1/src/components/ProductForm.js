import React, { useState } from "react";


export default (props) =>{
    const [title,setTitle] = useState(props.initialTitle);
    const [price,setPrice] = useState(props.initialPrice);
    const [description , setDescription] = useState(props.initialDescription);
    const [head,setHead] = useState(props.theHead);
    const [btn,setBtn] = useState(props.theBtn);

    

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
        props.created({title,price,description});
        setTitle("");
        setPrice("");
        setDescription("");
    }

    return (
        <>
        <h2>{head}</h2>
        <form onSubmit={onSubmitHandle}>
            
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
                    <td style={forTd}><input type="text" onChange={(e)=>setDescription(e.target.value)} value={description} /></td>
                </tr>
            </table>
            <input type="submit" value={btn} style={forInput}/>
        </form>
        <br/><hr/>
        </>
    )
}