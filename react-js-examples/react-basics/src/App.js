import Expenses from "./components/Expenses/Expenses";
import NewExpense from "./components/NewExpense/NewExpense";


function App() {
  const expenses = [
    {
      id: "e1",
      title: "Car Insurance", 
      amount: 458.78,
      date: new Date(2022, 6, 18)
    },
    {
      id: "e2",
      title: "Tesco", 
      amount: 6.00, 
      date: new Date(2022, 7, 12)
    },
    {
      id: "e3",
      title: "Udemy", 
      amount: 13.99, 
      date: new Date(2022, 7, 12)
    },
    {
      id: "e4",
      title: "MOT", 
      amount: 325.11, 
      date: new Date(2022, 7, 16)
    },
  ]

  const addExpenseHandler = expense => {
    console.log(expenses);
  };

  return (
    <div className="App">
     <NewExpense onAddExpense={addExpenseHandler} />
     <Expenses expenses={expenses} />
    </div>
  );
}

export default App;
