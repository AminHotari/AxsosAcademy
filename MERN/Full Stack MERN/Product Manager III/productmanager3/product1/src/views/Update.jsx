import { navigate } from '@reach/router';
import axios from 'axios';
import React, { useEffect , useState } from 'react'


const Update = (props) => {
    const [title,setTitle] = useState("");
    const [price,setPrice] = useState(0.0);
    const [description , setDescription] = useState("");

    useEffect(()=>{
        axios.get('http://localhost:8000/api/product/' +props.id)
            .then(res=>{
                setTitle(res.data.title);
                setPrice(res.data.price);
                setDescription(res.data.description);
            })
            .catch(err=> console.log(err))
    },[])


    const updateProduct = (e) =>{
        e.preventDefault();
        navigate(`/${props.id}`);
        axios.put('http://localhost:8000/api/product/' +props.id,{
            title,
            price,
            description,
        })
            .then(res=> console.log(res))
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
    <div>
        <h2>Update a Product</h2>
        <form onSubmit={updateProduct}>
            <table style={forTable}>
                <tr>
                    <td style={forTr}>Title</td>
                    <td style={forTd}><input type="text" name="title" onChange={(e)=>setTitle(e.target.value)} value={title} /></td>
                </tr><br></br>
                <tr>
                    <td style={forTr}>Price</td>
                    <td style={forTd}><input type="number" name="price" step="0.01" min= "0" onChange={(e)=>setPrice(e.target.value)} value={price} /></td>
                </tr><br></br>
                <tr>
                    <td style={forTr}>Descreption</td>
                    <td style={forTd}><input type="text" name="description" onChange={(e)=>setDescription(e.target.value)} value={description} /></td>
                </tr>
            </table>
            <input type="submit" value="Update" style={forInput}/>
        </form>
    </div>
  )
}

export default Update
