import axios from 'axios'
import React from 'react'

const DeleteButton = (props) => {

    const deleteAuthor = (e)=>{
        axios.delete('http://localhost:8000/api/author/' +props.authorId)
        .then(res=>{props.success()})
        .catch(err=>console.log(err))
    }
  return (
    <div>
      <button onClick={deleteAuthor}>Delete</button>
    </div>
  )
}

export default DeleteButton
