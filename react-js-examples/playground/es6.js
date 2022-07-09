const getIDs = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve([111,222,333,444,555]);
    }, 1500);
});

const getRecipe = recID => {
    return new Promise((resolve, reject) => {
       setTimeout(ID => {
          const recipe = {
              title: "pasta",
              publisher: "Degere"};
          resolve(`${ID}: ${recipe.title}`)
       }, 1500, recID);
    });
}

const getRelated = publisher => {
    return new Promise((resolve, reject) => {
       setTimeout(pub => {
           const recipe = {
               title: "pizza",
               publisher: "Degere"};
           resolve(`${pub}: ${recipe.title}`);
       }, 1500, publisher);
    });
}

async function getRecipesAW() {
    const IDs = await getIDs;
    console.log(IDs);

    const recipe = await getRecipe(IDs[2]);
    console.log(recipe);

    const related = await getRelated("Degere");
    console.log(related);
}
getRecipesAW();