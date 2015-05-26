jQuery.namespace("JIRA.Admin.Team.EditTeamRow");

JIRA.Admin.Team.EditTeamRow = JIRA.RestfulTable.EditRow.extend({
    submit: function() {
        JIRA.RestfulTable.EditRow.prototype.submit.apply(this, arguments);
    },
    render: function() {

        var data = this.model.toJSON(),
            $el = this.$el;

        $el.html(JIRA.Templates.Team.editTeamRow({
            team: data
        }));

        return this;
    }
});
