import axios from 'axios'
import React from 'react'

const DeleteButton = (props) => {

    const deleteProduct = (e)=>{
        axios.delete('http://localhost:8000/api/product/' +props.productId)
        .then(res=>{props.success();})
        .catch(err=>console.log(err))
    }
  return (
    <div>
      <button onClick={deleteProduct}>Delete</button>
    </div>
  )
}

export default DeleteButton
