import { useState } from "react";

import Card from "../UI/Card";
import ExpensesChart from './ExpensesChart';
import ExpensesList from "./ExpensesList";
import ExpensesFilter from './ExpensesFilter';
import "./Expenses.css";

function Expenses(props) {
    const [filteredYear, setFilteredYear] = useState('2020');

    const filterChangeHandler = selectedYear => {
        setFilteredYear(selectedYear);
    };

    const filteredExpenses = props.expenses.filter(
        (expense) => {
            return expense.date.getFullYear().toString() === filteredYear;
        }
    );

    console.log("entered expenses: ")
    console.log(props.expenses);
    

    return (
        <div>
            <Card className="expenses">
                <ExpensesFilter 
                selected={filteredYear} 
                onChangeFilter={filterChangeHandler} />
                <ExpensesChart expenses={filteredExpenses} />
                <ExpensesList filteredExpenses={filteredExpenses} />
            </Card>
        </div>
    );
}

export default Expenses;