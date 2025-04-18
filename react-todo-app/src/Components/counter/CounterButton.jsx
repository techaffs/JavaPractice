import PropTypes from 'prop-types';

export default function CounterButton({by, incrementMethod, decrementMethod}) {
    
    return (
        <div className="Counter">
            <div>
                <button id="inc1" className="counterButton" 
                    onClick={() => incrementMethod(by)}
                 >+{by}</button>
                <button id="dec1" className="counterButton" 
                    onClick={() => decrementMethod(by)}
                 >-{by}</button>
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
}
CounterButton.defaultProps = {
    by: 1
}