import { useState } from 'react';
import CounterButton from './CounterButton';

import './Counter.css';


export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by);
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by);
    }

    function resetCounter() {
        setCount(0);
    }

    return (
        <div>
            <span className="totalCount">{count}</span>
            <div className="Counter">
                <CounterButton by={1} 
                    incrementMethod={incrementCounterParentFunction}
                    decrementMethod={decrementCounterParentFunction}/>
                <CounterButton by={2}
                    incrementMethod={incrementCounterParentFunction}
                    decrementMethod={decrementCounterParentFunction}/>
                <CounterButton by={3}
                    incrementMethod={incrementCounterParentFunction}
                    decrementMethod={decrementCounterParentFunction}/>
                <button className="resetButton"
                        onClick={resetCounter}
                >Reset</button>
            </div>
        </div>
    )
}

