import Expenses from "./components/Expenses/Expenses";
import NewExpense from "./components/NewExpense/NewExpense";


function App() {
  const expenses = [
    {title: "Car Insurance", amount: 458.78, date: new Date(2022, 6, 18)},
    {title: "Tesco", amount: 6.00, date: new Date(2022, 7, 12)},
    {title: "Udemy", amount: 13.99, date: new Date(2022, 7, 12)},
    {title: "MOT", amount: 325.11, date: new Date(2022, 7, 16)},
  ]

  return (
    <div className="App">
     <NewExpense />
     <Expenses expenses={expenses}/>
    </div>
  );
}

export default App;
