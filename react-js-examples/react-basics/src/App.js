import { useState } from "react";

import INITIAL_EXPENSES from "./utils";
import Expenses from "./components/Expenses/Expenses";
import NewExpense from "./components/NewExpense/NewExpense";


function App() {
  const [expenses, setExpenses] = useState(INITIAL_EXPENSES);

  const addExpenseHandler = (expense) => {
    console.log("within addExpenseHandler, the expense object is: ")
    console.log(expense)
    setExpenses((prevExpenses) => {
      return [expense, ...prevExpenses];
    }); 
  };

  return (
    <div className="App">
      <NewExpense onAddExpense={addExpenseHandler} />
      <Expenses expenses={expenses} />
    </div>
  );
}

export default App;
