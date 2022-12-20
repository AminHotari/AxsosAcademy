import { Link } from '@reach/router';
import axios from 'axios';
import React, { useEffect, useState } from 'react'

const Detail = (props) => {
    const [theProduct,setTheProduct] = useState({})

    useEffect(()=>{
        axios.get('http://localhost:8000/api/product/' +props.id)
            .then(res=> {setTheProduct(res.data)})
            .catch(err=> console.error(err))
    },[]);
  return (
    <div>
      <h3>{theProduct.title}</h3>
      <p>Price: ${theProduct.price}</p>
      <p>Description: {theProduct.description}</p>
      <Link to={"/"}>Back to Main</Link>
    </div>
  )
}

export default Detail
