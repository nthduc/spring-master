import { useState } from 'react';
import { BrowserRouter, Link, Route, Routes, useNavigate, useParams } from 'react-router-dom';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            Todo Management Application
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LoginComponent />} />
                    <Route path="/login" element={<LoginComponent />} />
                    <Route path="/welcome/:username" element={<WelcomeComponent />} />
                    <Route path="/todos" element={<ListTodosComponent />} />

                    <Route path="*" element={<ErrorComponent />} />



                </Routes>
            </BrowserRouter>
        </div>
    )
}


function LoginComponent() {

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)

    const navigate = useNavigate()


    function handleUsernameChange(event) {
        console.log(event)
        setUsername(event.target.value)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        console.log(username)
        console.log(password)
        if (username === "nthduc" && password === "123") {
            console.log("Success")
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
        } else {
            console.log("Failed")
            setShowErrorMessage(true)
            setShowSuccessMessage(false)
        }
    }

    return (
        <div className="Login">
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
            {showErrorMessage && <div className="successMessage">Authenticated Failed</div>}
            <SuccessMessageComponent />
            <ErrorMessageComponent />
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange} />
                </div>

                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>

                <div>
                    <button type="button" className="Login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
            Login Component
            {/* <WelcomeComponent /> */}
        </div>
    )

    function SuccessMessageComponent() {
        if (showSuccessMessage) {
            return <div className="successMessage">Authenticated Successfully</div>
        }
        return null
    }


    function ErrorMessageComponent() {
        if (showErrorMessage) {
            return
        }
        return null
    }

}



function WelcomeComponent() {

    const { username } = useParams()


    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manager your todos - <Link href="/todos">Go here</Link>
            </div>
        </div>
    )
}


function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies! for the 404
            </div>
        </div>
    )
}

function ListTodosComponent() {


    const today = new Date();
    const targetDate = new Date(today.getFullYear() + 12, today.getMonth(), today.getDay())

    const todos = [
        { id: 1, description: "Learn AWS", done: false, targetDate: targetDate },
        { id: 2, description: "Learn FullStack", done: false, targetDate: targetDate },
        { id: 3, description: "Learn DevOps", done: false, targetDate: targetDate }
    ]

    return (
        <div className="ListTodosComponent">
            <h1>Things you want to do</h1>
            <div>
                <table>
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Description</td>
                            <td>Is Done ?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>

                    <tbody>

                        {
                            todos.map(todo => (
                                <tr key={todo.id}>
                                    <td>{todos.id}</td>
                                    <td>{todos.description}</td>
                                    <td>{todos.done}</td>
                                    <td>{todos.targetDate.toDateString()}</td>
                                </tr>
                            ))
                        }


                    </tbody>
                </table>
            </div>
        </div>
    )
}