export default {
    data() {
        return {
            data: [],
            search: "",
            searchColumn: []
        };
    },
    computed: {
        filteredItems() {
            return this.data.filter(item => {
                return item[this.searchColumn].toLowerCase().includes(this.search.toLowerCase());
            });
        }
    }
};
