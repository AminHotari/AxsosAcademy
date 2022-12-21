import axios from 'axios';
import React, { useEffect, useState } from 'react'
import ProductForm from '../components/ProductForm'
import ProductList from '../components/ProductList'


const Main = () => {
    // const [message, setMessage] = useState("Loading..")

    // useEffect(()=>{
    //     axios.get("http://localhost:8000/api")
    //     .then(res=>setMessage(res.data.message))
    // }, []);

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

    const deleteFromDom = productId =>{
      setProducts1(products1.filter(product => product._id != productId));
    }

    const createProduct = product1 =>{
      axios.post('http://localhost:8000/api/product', product1)
        .then(res=> {setProducts1([...products1,res.data])})
        .catch(err=> console.log(err))      
  }

  return (
    <div>
        <ProductForm created={createProduct} />
        {loaded && <ProductList prod={products1} remove={deleteFromDom}/>}
    </div>
  )
}

export default Main
