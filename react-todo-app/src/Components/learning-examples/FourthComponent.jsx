import { Component } from 'react';

export default class FourthComponent extends Component { //Class Component
  render() {
    return (
      // Empty Parent Wrapper
      <> 
      <div className="fourthComponent">
        <h1>Fourth Component</h1>
      </div>
      <div className="fourthComponent">
        <h1>Fourth Component</h1>
      </div>
    </>
    );
  }
}