const express = require('express')
var ip = require('ip');

const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!\nIp: ' + ip.address() + "\n");
  console.log(ip.address() + "\n");
});
app.get('/hello/hello', (req, res) => {
  res.send('Hello');
  console.log(ip.address() + "\n");
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})