
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Authors from '../components/Authors'



const Main = () => {
    const [authors,setAuthors] = useState([]);
    const [loaded,setLoaded] = useState(false);

    useEffect(()=>{
        axios.get("http://localhost:8000/api/author")
        .then(res =>{
          setAuthors(res.data);
          setLoaded(true);
        })
        .catch(err=> console.error(err));
    },[]);

  const removeAuthor =(authorId)=>{
    setAuthors(authors.filter(author => author._id != authorId));
  }

  return (
    <div>      
      {loaded && <Authors auth={authors} path="/" remove={removeAuthor}/>}    
    </div>
  )
}

export default Main
