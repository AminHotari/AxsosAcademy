
import { navigate} from '@reach/router'
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import AuthorForm from './AuthorForm'

const Update = (props) => {
  const [author,setAuthor] = useState();
  const [loaded,setLoaded] = useState(false);
  const [title,setTitle] = useState(props.title)
  const [authors,setAuthors] = useState([]);
  const [error,setError] = useState([]);

  useEffect(()=>{
    axios.get('http://localhost:8000/api/author/' + props.id)
    .then(res=>{
      setAuthor(res.data);
      setLoaded(true);
    })
    .catch(err=>console.log(err));
  },[])

  const updateAuthor = (theAuthor)=>{
    axios.put('http://localhost:8000/api/edit/author/'+ props.id ,theAuthor)
    .then(res=>{setAuthors([...authors,res.data],navigate("/"))})
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
      {loaded && <AuthorForm created={updateAuthor} initialName={author.name} title="Edit this author" error={error}/>}
    </div>
  )
}

export default Update
