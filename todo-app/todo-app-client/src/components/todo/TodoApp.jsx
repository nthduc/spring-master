import { useState } from 'react';
import './TodoApp.css';

export default function TodoApp() {
    return (
        <div className="TodoApp">
            Todo Management Application
            <LoginComponent />
            {/* <WelcomeComponent /> */}
        </div>
    )
}


function LoginComponent() {
    
    const [username,setUsername] = useState("")
    const [password,setPassword] = useState("")
    const [showSuccessMessage,setShowSuccessMessage] = useState(false)
    const [showErrorMessage,setShowErrorMessage] = useState(false)


    function handleUsernameChange(event){
        console.log(event)
        setUsername(event.target.value)
    }

    function handlePasswordChange() {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        console.log(username)
        console.log(password)
        if(username === "nthduc" && password === "123"){
            console.log("Success")
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
        } else {
            console.log("Failed")
            setShowErrorMessage(true)
            setShowSuccessMessage(false)
        }
    }

    return (
        <div className="Login">
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
            <WelcomeComponent />
        </div>
    )

    function SuccessMessageComponent() {
        if(showSuccessMessage){
            return <div className="successMessage">Authenticated Successfully</div>
        }
        return null
    }


    function ErrorMessageComponent() {
        if(showErrorMessage){
            return <div className="successMessage">Authenticated Failed</div>
        }
        return null
    }
    
}



function WelcomeComponent() {
    return (
        <div className="Login">
            Welcome Component
        </div>
    )
}