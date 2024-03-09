const Pool = require("pg").Pool;

const pool = new Pool({
    user:"aniketpatole",
    password:"Aniket@0699",
    host:"localhost",
    port:5432,
    database:"todopernstack"
});

module.export = pool;