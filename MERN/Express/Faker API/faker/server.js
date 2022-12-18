const express = require("express");
const app = express();
const port = 8000;

app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );

const {faker} = require('@faker-js/faker');

const createUser = ()=>{
    const newUser={
        userId:faker.datatype.uuid(),
        firstName: faker.name.firstName(),
        lastName:faker.name.lastName(),
        email:faker.internet.email(),
        password:faker.internet.password(),
        phoneNumber:faker.phone.phoneNumber(),
    }
    return newUser;
};

const createCompany =()=>{
    newCompany={
        companyId:faker.datatype.uuid(),
        name:faker.company.name(),
        address:[{"street":faker.address.street(),"city":faker.address.city(),"state":faker.address.state(),"zipCode":faker.address.zipCode(),"country":faker.address.county()}]
    }
    return newCompany;
};

app.get("/api/users/new" ,(req,res)=>{
    res.json(createUser());
});

app.get("/api/companies/new" ,(req,res)=>{
    res.json(createCompany());
});

app.get("/api/user/company" ,(req,res)=>{

    const user = createUser();
    const company = createCompany();
    const userCompany = {user,company};
    res.json(userCompany);
});

const newFakerUser = createUser();
const newFakerCompany= createCompany();

console.log(newFakerUser);
console.log(newFakerCompany);

const server = app.listen(port, () =>
  console.log(`Listening on port ${port}!`)
);

