import { useNavigate, useParams } from "react-router-dom";
import { getTodo, updateTodo, createTodo } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import { useEffect, useState } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import moment from "moment";

function ToDoComponent() {

    const { id } = useParams();
    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');

    const authContext = useAuth();
    const username = authContext.username;

    const navigate = useNavigate();

    useEffect(() => {
        getTodoById();
    }, [id]);

    function getTodoById() {
        if (id != -1)
        {
            getTodo(username, id)
                .then(response => {
                    setDescription(response.data.description);
                    setTargetDate(response.data.targetDate);
                })
                .catch(error => console.log(error))
                .finally(() => console.log('Finally called'));
        }
    }

    function updateTodoById(values) {
        
                const todo = {id:id, username:username, description: values.description, targetDate: values.targetDate, isDone: false};
                updateTodo(username, id, todo)
                    .then(response => navigate('/todos'))
                    .catch(error => console.log(error))
                    .finally(() => console.log('Finally called'));
    }

    function newTodo(values) {
                const todo = {username:username, description: values.description, targetDate: values.targetDate, isDone: false};
                createTodo(username, todo)
                    .then(response => navigate('/todos'))
                    .catch(error => console.log(error))
                    .finally(() => console.log('Finally called'));
    }
    
    

    return (
        <div className="container">
            <h1>Enter ToDo Details</h1>
            <div>
                <Formik onSubmit={values => (id == -1 ? newTodo(values) : updateTodoById(values))} 
                        initialValues={{description, targetDate}} 
                        enableReinitialize={true}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={values => {
                            const errors = {};
                            if (!values.description) {
                                errors.description = 'Enter a Description';
                            } else if (values.description.length < 5) {
                                errors.description = 'Enter atleast 5 Characters in Description';
                            }
                            if (!values.targetDate || values.targetDate === '' || !moment(values.targetDate).isValid()) {
                                errors.targetDate = 'Enter a Target Date';
                            }
                            return errors;
                            }
                        }
                        >
                    {
                        (props) => (
                        <Form>
                            <ErrorMessage name="description" component="div" className="alert alert-warning" />
                            <ErrorMessage name="targetDate" component="div" className="alert alert-warning" />
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field className="form-control" type="text" name="description" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field className="form-control" type="date" name="targetDate" />
                            </fieldset>
                            <button className="btn btn-success m-5" type="submit">Save</button>
                        </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}


export default ToDoComponent;