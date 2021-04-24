(async () => {
    const url = 'http://localhost:3000/api/restaurants'
    const response = await fetch(url)
    const data = await response.json()


    const element = document.getElementById('app')
    element.innerHTML = `
        ${data.map(restaurant=>`
           <p>
                ${restaurant.id}
                ${restaurant.name}
                ${restaurant.address}
            </p>
        `).join('')}
    `
})();