import './ToDoApp.css';
import {BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import LogoutComponent from './LogoutComponent';
import FooterComponent from './FooterComponent';
import HeaderComponent from './HeaderComponent';
import WelcomeComponent from './WelcomeComponent';
import ErrorComponent from './ErrorComponent';
import ListToDoComponent from './ListToDoComponent';
import LoginComponent from './LoginComponent';
import { AuthProvider, useAuth } from './security/AuthContext';
import ToDoComponent from './ToDoComponent';

function AuthenticatedRoute({children}){
    const authContext = useAuth();
    if(authContext.isAuthenticated)
        return children
    
    return <Navigate to="/" />
}

export default function TodoApp(){
    return (
        <div className="TodoApp">
            <p/>
            <AuthProvider>
                <Router>
                <HeaderComponent/>
                    <Routes>
                        <Route path='/' element={<LoginComponent />} />
                        <Route path='/login' element={<LoginComponent />} />
                        <Route path='/welcome/:username' element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>} />
                        <Route path='/todos' element={
                            <AuthenticatedRoute>
                                <ListToDoComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path='/todo/:id' element={
                            <AuthenticatedRoute>
                                <ToDoComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='/logout' element={
                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path='*' element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent/>
                </Router>
            </AuthProvider>
        </div>
    )
}
















