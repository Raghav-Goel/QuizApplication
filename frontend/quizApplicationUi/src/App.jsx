import { useState } from 'react'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <form class="row row-cols-lg-auto g-3 align-items-center">
        <div class="form-group">
          <label class="form-label"> Username </label>
          <input type="text" class="form-control" />
        </div>
        <div class="form-group">
          <label class="form-label">Password</label>
          <input type="password" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </>
  )
}

export default App
