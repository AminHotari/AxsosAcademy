import axios from 'axios';
import React, { useEffect, useState } from 'react'
import ProductForm from '../components/ProductForm'
import ProductList from '../components/ProductList'


const Main = () => {
    

    const [products1,setProducts1] = useState([]);
    const [loaded,setLoaded] = useState(false);

    useEffect(()=>{
        axios.get("http://localhost:8000/api/product")
        .then(res =>{
            setProducts1(res.data);
            setLoaded(true);
        })
        .catch(err=> console.error(err));
    },[]);

   

  return (
    <div>
        <ProductForm/>
        {loaded && <ProductList prod={products1}/>}
    </div>
  )
}

export default Main
