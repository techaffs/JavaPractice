import FirstComponent from './FirstComponent';
import { FifthComponent } from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
import LearningJavascript from './LearningJavascript';


export default function LearningComponent() {
    return (
      <div className="App">
        <FirstComponent />
        <SecondComponent />
        <ThirdComponent />
        <FourthComponent />
        <FifthComponent />
        <LearningJavascript />
      </div>
    );
  }