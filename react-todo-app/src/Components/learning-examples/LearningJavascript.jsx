const person = {
    name: 'John',
    age: 25,
    address: {
        line1: 'Wall street',
      city: 'New York',
        state: 'NY',
    },
    hobbies: ['Reading', 'Cooking'],

    printDetails: () => {
        console.log(`Name: ${person.name}, Age: ${person.age}`);
        console.log(`Address: ${person.address.line1}, ${person.address.city}, ${person.address.state}`);
        console.log(`Hobbies: ${person.hobbies.join(', ')}`);
    }
}

export default function LearningJavascript() {
    return (
      <>
            <div>{person.printDetails()}</div>
      </>
    );
  }