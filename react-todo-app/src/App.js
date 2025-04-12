import logo from './logo.svg';
import './App.css';
import './Components/learning-examples/LearningComponent';
import LearningComponent from './Components/learning-examples/LearningComponent';
import Counter from './Components/counter/Counter';
import TodoApp from './Components/todo/ToDoApp';



function App() {
  return (
    <div className="App">
      {/* <PlayingWithProps property1="value1" property2="value2"/> Example of Props use*/}
      {/* < Counter /> */}
      <TodoApp />
    </div>
  );
}

// function PlayingWithProps(properties) { //Example of Props use
//   console.log(properties);
//   console.log(properties.property1);
//   console.log(properties.property2);
//   return (
//     <div>
//         Props
//     </div>
//   );
// }

// function PlayingWithProps( {property1, property2} ) { //Example of Props use
//   console.log(property1);
//   console.log(property2);
  
//   return (
//     <div>
//         Props
//     </div>
//   );
// }

export default App;
