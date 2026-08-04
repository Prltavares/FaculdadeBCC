const express = require('express');

const app = express();

app.get('/ola'), (req,res)=>res.send('ola');

app.get('/monk'), (req,res)=>res.send('mundo');

app.listen(3000);

