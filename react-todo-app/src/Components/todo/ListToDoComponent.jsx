import { useEffect, useState } from "react";
import { deleteTodo, getAllTodosByUsername } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useNavigate } from "react-router-dom";

export default function ListToDoComponent(){

    // const today = new Date();
    // const targetDate = new Date(today.getFullYear() + 1, today.getMonth(), today.getDate());

    const authContext = useAuth();
    const username = authContext.username;

    const [todos, setTodos] = useState([]);

    const navigate = useNavigate();

    // const todos = [
    //                 // {id: 1, description: 'Learn React', targetDate: targetDate, isDone: false},
    //                 // {id: 2, description: 'Learn Spring', targetDate: targetDate, isDone: false},
    //                 // {id: 3, description: 'Learn Angular', targetDate: targetDate, isDone: false},
    //                 // {id: 4, description: 'Learn Java', targetDate: targetDate, isDone: false},
    //                 // {id: 5, description: 'Learn Python', targetDate: targetDate, isDone: false}
    //             ]

    useEffect(() => { //<<---- This is a hook
        refreshTodos();
    }, []);

    function refreshTodos() {
        getAllTodosByUsername(username)
            .then(response => setTodos(response.data))
            .catch(error => console.log(error))
            .finally(()=>console.log('Finally called'));
    } 

    function deleteTodoById(id){
        deleteTodo(username, id)
            .then(response => {
                console.log(response);
                refreshTodos(username);
            })
            .catch(error => console.log(error))
            .finally(()=>console.log('Finally called'));
    }

    function updateTodoById(id){
        navigate(`/todo/${id}`);
    }

    return( 
        <div className="container">
            <h1>Things You Want To Do!</h1>
            <div>
               <table  className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(
                            todo => 
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    {/* <td>{todo.targetDate.toDateString()}</td> */}
                                    <td>{todo.targetDate.toString()}</td>
                                    <td>{todo.isDone.toString()}</td>
                                    <td><button className='btn btn-success' onClick={() => updateTodoById(todo.id)}>Update</button></td>
                                    <td><button className='btn btn-warning' onClick={() => deleteTodoById(todo.id)}>Delete</button></td>
                                </tr>
                        )
                    }
                </tbody>
               </table>
            </div>
            <div className="btn btn-success m-5" onClick={() => navigate('/todo/-1')}>Add Todo</div> 
        </div>
    )
}