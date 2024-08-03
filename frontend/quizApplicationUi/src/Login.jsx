import { useState } from "react";

function Login(){
    const[defaultName,setNewName]=useState("Raghav")
    const setName=(event)=>{
        setNewName(event.target.value)
    }
    return (
        <>
          <form className="">
            <div className="form-group">
              <label className="form-label"> Username </label>
              <input type="text" className="form-control" value={defaultName} onChange={(event)=>setName(event)}/>
            </div>
            <div className="form-group">
              <label className="form-label">Password</label>
              <input type="password" className="form-control" />
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
          </form>
        </>
    )
}
export default Login;