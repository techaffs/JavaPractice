import { apiClient } from "./ApiClient";

export const getAllTodosByUsername = 
    (username) => apiClient.get(`/users/${username}/todos`);

export const deleteTodo =
    (username, id) => apiClient.delete(`/users/${username}/todo/${id}`);

export const getTodo =
    (username, id) => apiClient.get(`/users/${username}/todo/${id}`);

export const updateTodo =
    (username, id, todo) => apiClient.put(`/users/${username}/todo/${id}`, todo);

export const createTodo =
    (username, todo) => apiClient.post(`/users/${username}/todo`, todo);

