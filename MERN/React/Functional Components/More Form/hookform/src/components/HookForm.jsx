import React, {useState} from 'react';

const HookForm = (props) => {
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmpassword, setConfirmpassword] = useState("");
    const [errorFirstname, setErrorFirstname] = useState("");
    const [errorLastname, setErrorLastname] = useState("");
    const [errorEmail, setErrorEmail] = useState("");
    const [errorPassword, setErrorPassword] = useState("");
    const [errorConfirmPassword, setErrorConfirmPassword] = useState("");

    const createUser = (e) => {
        e.preventDefault();
        const newUser = {firstname, lastname, email, password, confirmpassword};
        console.log("Welcome", newUser);
    };

    const forFirstname = (e) => {
        setFirstname(e.target.value);
        if(e.target.value.length < 1){
            setErrorFirstname("This field is required!");
        }
        else if(e.target.value.length < 2){
            setErrorFirstname("This field must be at least 2 characters!");
        }
        else{
            setErrorFirstname("");
        }
    }

    const forLastname = (e) => {
        setLastname(e.target.value);
        if(e.target.value.length < 1){
            setErrorLastname("This field is required!");
        }
        else if(e.target.value.length < 2){
            setErrorLastname("This field must be at least 2 characters!");
        }
        else{
            setErrorLastname("");
        }
    }

    const forEmail =(e) => {
        setEmail(e.target.value);
        if(e.target.value.length < 1){
            setErrorEmail("");
        }
        else if(e.target.value.length < 5){
            setErrorEmail("This field must be at least 5 characters!");
        }
        else{
            setErrorEmail("");
        }
    }
    const forPassword =(e) => {
        setPassword(e.target.value);
        if(e.target.value.length < 1){
            setErrorPassword("");
        }
        else if(e.target.value.length < 8){
            setErrorPassword("This field must be at least 8 characters!");
        }
        else{
            setErrorPassword("");
        }
    }

    const forConfirmPassword =(e) => {
        setConfirmpassword(e.target.value);
        if(e.target.value.length < 1){
            setErrorConfirmPassword("");
        }
        else if(e.target.value != password){
            setErrorConfirmPassword("This field must be match with Password!");
        }
        else{
            setErrorConfirmPassword("");
        }
    }
    
    
    
    


  return (
    <>
    <form onSubmit={createUser}>
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" onChange={ forFirstname } /></td>
                {errorFirstname ? <p>{errorFirstname}</p> : ''}
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" onChange={forLastname} /></td>
                {errorLastname ? <p>{errorLastname}</p> : ''}
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" onChange={forEmail } /></td>
                {errorEmail ? <p>{errorEmail}</p> : ''}
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" onChange={forPassword }/></td>
                {errorPassword ? <p>{errorPassword}</p> : ''}
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" onChange={forConfirmPassword } /></td>
                {errorConfirmPassword ? <p>{errorConfirmPassword}</p> : ''}
            </tr>
        </table>
        <input type="submit" value="Create User" />    
    </form>
    </>
    
  );
}

export default HookForm