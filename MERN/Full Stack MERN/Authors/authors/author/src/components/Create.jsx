import React, { useState } from 'react'
import AuthorForm from './AuthorForm'
import axios from 'axios';
import {navigate} from '@reach/router'

const Create = (props) => {
    const [authors,setAuthors] = useState([]);
    const [error,setError] = useState([]);

    const createAuthor = author =>{
        axios.post('http://localhost:8000/api/author', author)
        .then(res=> {setAuthors([...authors,res.data], navigate("/"))})
        .catch(err=>{
            const errorResponse = err.response.data.errors;
            const errorArr = [];
            for (const key of Object.keys(errorResponse)){
              errorArr.push(errorResponse[key].message)
            }
            setError(errorArr);
          })      
        }   
  return (
    <div>
      <AuthorForm created={createAuthor} initialName="" title="Add a new author" error={error}/>
    </div>
  )
}

export default Create
